import java.util.ArrayList;

public class OrganizerRunner {
	public static void sendToTop(ArrayList<Album> albumList, int position) {
		
		Album temp = albumList.get(0);
		albumList.set(0, albumList.get(position));
		albumList.set(position, temp);
		
	}
	public class Album {
		int label;
		String name;
		public Album (String name) {
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		//OrganizerRunner runner = new OrganizerRunner();
		//String[] args = {"1", "3", "Album 1", "Album 3", "Album 2"};
		int numberOfStacks = 0;
		int numberOfAlbumsInCurrentStack = 0;
		ArrayList<Album> stack = new ArrayList<Album>();
		ArrayList<Album> organizedStack = new ArrayList<Album>();
		ArrayList<Album> output = new ArrayList<Album>();
		numberOfStacks = Integer.parseInt(args[0]);
				//create numberOfStacks number of output arrayList
		int j = 1;
		for (int i = 0; i < numberOfStacks; i++) {
			int start = j;
			numberOfAlbumsInCurrentStack = Integer.parseInt(args[start]);
			while (j < start+numberOfAlbumsInCurrentStack) {
				stack.add(new Album(args[j]));	
				j++;
			}
			while (j < start+2*numberOfAlbumsInCurrentStack) {
				organizedStack.add(new Album(args[j]));
				j++;
			}
			int position = 0;
			for (Album album : organizedStack) {
				for (Album album2 : stack) 
					if (album.name == album2.name)
						album2.label = position;
				position++;
			}
			boolean notSorted = true;
			while (notSorted) {
				int min = 0;
				for (int z = 1; z<numberOfAlbumsInCurrentStack; z++) {
					if (stack.get(z).label < stack.get(min).label)
							min = z;
							sendToTop(stack, min);
							output.add(stack.get(z));
						if (stack.get(z).label == z) {
							notSorted = false;
						} else {
							notSorted = true;
						}
				}
								
			}
			
		}
	}
}
