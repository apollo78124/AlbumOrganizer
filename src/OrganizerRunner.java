import java.util.ArrayList;

public class OrganizerRunner {
	public static void sendToTop(ArrayList<Album> albumList, int position) {
		
		Album temp = albumList.get(position);
		albumList.remove(position);
		albumList.add(0, temp);
		
	}
	
	public static void main(String[] argss) {
		String[] args = {"1", "3", "Blues for Allah", "Skeletons from the Closet", "Terrapin Station", "Skeletons from the Closet", "Blues for Allah", "Terrapin Station"};
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
			j++;
			while (j < start+numberOfAlbumsInCurrentStack+1) {
				stack.add(new Album(args[j]));	
				j++;
			}
			while (j < 1+start+2*numberOfAlbumsInCurrentStack) {
				organizedStack.add(new Album(args[j]));
				j++;
			}
			int position = 0;
			for (Album album : organizedStack) {
				for (Album album2 : stack)  {
					if (album.name == album2.name)
						album2.label = position;
				}
				position++;
			}
			boolean sorted = false;
			while (!sorted) {
				int min = 0;
				int sameAsLabel = 0;
				if(stack.get(0).label == 0)
					min = 1;
				for (int z = 1; z<numberOfAlbumsInCurrentStack; z++) {
					if (stack.get(z).label < stack.get(min).label) {
						min = z;
					}	
						if (stack.get(z).label == z) {
							sameAsLabel++;
						}
				}
				if (sameAsLabel == numberOfAlbumsInCurrentStack-1)
					sorted = true;
				if (!sorted) {
					output.add(stack.get(min));
					sendToTop(stack, min);
				}	
			}
			for (Album album : output) {
				System.out.println(album.name);
			}
			System.out.println("\n");
		}
		
	}
}
