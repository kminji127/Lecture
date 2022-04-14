
public class Monitor {
	private char buffer[] = new char[6];
	private int eatnext = 0;
	private int addnext = 0;
	private boolean isFull = false;
	private boolean isEmpty = true;
	
	public synchronized char use() {
		char toReturn;
		while(isEmpty == true) {
			try {
				System.out.println("\t\tBuffer is empty.");
			wait();
			} catch(InterruptedException e) {	}
		}
		toReturn = buffer[eatnext];
		eatnext = (eatnext + 1) % 6;
		if(eatnext == addnext) {
			isEmpty = true;
		}
		isFull = false;
		notify();
		return(toReturn);
	}
	
	public synchronized void add(char c) {
		while(isFull == true) {
			try {
				System.out.println("\t\tBuffer is full.");
				wait();
			} catch(InterruptedException e) { }
			buffer[addnext] = c;
			addnext = (addnext + 1) % 6;
			if(eatnext == addnext) {
				isFull = true;
			}
			isEmpty = false;
			notify();
		}
	}
}
