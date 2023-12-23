int main() {
	char* p = "hello";
	unsigned long t = p;
	void** pv = &p;
	printf("1: 0x%08x 0x%08x 0x%08x %s\n", t, pv, *pv, p);
	
	int ii = 101;
	p = &ii;
	printf("2: 0x%08x 0x%08x %d\n", p, &p, *p);
	
	p = 0x01234567;
  	printf("3: 0x%08x 0x%08x\n", p, &p);
}
