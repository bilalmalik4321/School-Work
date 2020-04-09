#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <unistd.h>
#include <fcntl.h>


const int pgTableSize = 256;//256 bytes of page table size
const int bufSize = 256;//256 bytes of buffer size
const int physicalMemorySize = 256;//256 bytes of physical memory size size
const int tableSize = 16;//numbers of pages in table

struct TranslationLookasideBuffer {    //structure of a TLB, includes an index and tlb frame for each row in the tlb
	unsigned char pageIndex[16];
	unsigned char TLBframe[16];
	int ind;
};

int readFromDisk (int pNumber, char *PM, int* OF){//called to look at the backing store for memory once a page fault occurs (worst case)

	char buffer[bufSize];//the buffer array with a size of 256
	memset(buffer, 0, sizeof(buffer));

	FILE *BS;
	BS = fopen("BACKING_STORE.bin", "rb");//The backing store file to be used on page faults is placed in the BS variable holder and accessed through there for read and write
	if (BS == NULL){
		printf("File failed to open\n");//check if the file exists in the current directory, if not print this
		exit(0);
	}


	if (fseek(BS, pNumber * physicalMemorySize, SEEK_SET)!=0)//seek to the position where the memory is located by multiplying the page number passed in by the physical memmory size of 256, representing the size of eachpiece of memory
		printf("error in fseek\n");//if this failed then print the following

	if (fread(buffer, sizeof(char), physicalMemorySize, BS)==0)//read the 256 bytes from the current position, that is the entirety of the memory stored
		printf("error in fread\n");//print this if the read fails


	int i = 0;
	for(i; i < physicalMemorySize; i++){//the exact offset frame is calculated, the location of the ending of the memory
		*((PM+(*OF)*physicalMemorySize)+i) = buffer[i];
	}

	(*OF)++;

	return (*OF)-1;
}





int findPage(int logicalAddress, char* PT, struct TranslationLookasideBuffer *tlb,  char* PM, int* OF, int* pageFaults, int* hits){

	unsigned char maskingVal = 0xFF;//masking with the number 255 written in hexadecimal
	unsigned char PageOffset;
	unsigned char pNumber;
	bool TableHit = false;
	int frame = 0;
	int value;
	int newFrame = 0;

	printf("Virtual address: %d\t", logicalAddress);

	pNumber = (logicalAddress >> 8) & maskingVal;

	PageOffset = logicalAddress & maskingVal;

	//Check if in TLB
	int i = 0;
	for (i; i < tableSize; i++){
		if(tlb->pageIndex[i] == pNumber){
			frame = tlb->TLBframe[i];
			TableHit = true;
			(*hits)++;
		}

	}

	//Check if in PageTable
	if (TableHit == false){
		if (PT[pNumber] != -1){
		}

		else{
			newFrame = readFromDisk(pNumber, PM, OF);
			PT[pNumber] = newFrame;
			(*pageFaults)++;

		}
		frame = PT[pNumber];
		tlb->pageIndex[tlb->ind] = pNumber;
		tlb->TLBframe[tlb->ind] = PT[pNumber];
		tlb->ind = (tlb->ind + 1)%tableSize;

	}
	int index = ((unsigned char)frame*physicalMemorySize)+PageOffset;
	value = *(PM+index);
	printf("Physical address: %d\t Value: %d\n",index, value);


	return 0;


}




int main (int argc, char* argv[]){

    //variable declaration block
    float pageFaultRate;
	float TLBHitRate;
	int value;
	FILE *fd;
	int ofFrame = 0;
	int pageFaults = 0;
	int hits = 0;
	int inputCount = 0;


	unsigned char PageTable[pgTableSize];
	memset(PageTable, -1, sizeof(PageTable));

	struct TranslationLookasideBuffer tlb;
	memset(tlb.pageIndex, -1, sizeof(tlb.pageIndex));
	memset(tlb.TLBframe, -1, sizeof(tlb.TLBframe)); //initializing a tlb and giving its corresponding values
	tlb.ind = 0;

	char PhyMem[physicalMemorySize][physicalMemorySize];// total physical memory 256*256

	if (argc < 2){ //check if an argument was even passed on execution, if this is not true; to then exit the program
		printf("Need an argument to run the program \n");
		exit(0);
	}

	fd = fopen(argv[1], "r"); //open the text file passed as argument
	if (fd == NULL){ //check if the argument passed is an actual file in the working directory; if false to then exit the program
		printf("File not found\n");
		exit(0);
	}

	while (fscanf(fd, "%d", &value)==1){  //read in contents of addresses.txt
		findPage(value, PageTable, &tlb, (char*)PhyMem, &ofFrame, &pageFaults, &hits);
		inputCount++;
	}

	pageFaultRate = (float)pageFaults / (float)inputCount; //calculate page fault rate by dividing the number of pagefaults by total nuber of inputs
	TLBHitRate = (float)hits / (float)inputCount; //calculate page fault rate by dividing the number of pagefaults by total nuber of inputs
	printf("Page Fault Rate = %.4f\nTLB hit rate= %.4f\n",pageFaultRate, TLBHitRate);//display both rates
	close(fd);//close the file descriptor for input


	return 0;

}
