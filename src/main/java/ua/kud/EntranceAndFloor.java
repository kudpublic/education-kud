package ua.kud;

public class EntranceAndFloor {
    public static void main(String[] args) {
        for (int i = 1; i < 110; i++) {
            System.out.println(getAddress(9, 3, i));
        }
    }
    
    private static Address getAddress(int floors, int floorRooms, int roomNumber) {
    	Address adr = new Address();
    	
    	adr.roomNumber = roomNumber;
    	
    	int entranceRooms = floorRooms * floors;
    	
    	adr.entrance = (roomNumber / entranceRooms) + 1;
    	
    	// adge case when it is last room of last floor
    	if (roomNumber % entranceRooms == 0) {
    		adr.entrance--;
    	}
    	
    	adr.floor = ((roomNumber - entranceRooms * (adr.entrance - 1)) / floorRooms) + 1;
    	// adge case when it is last room on the floor
    	if (roomNumber % floorRooms == 0) {
    		adr.floor--;
    	}
    	
    	return adr;
    }

   private static class Address {
        int entrance;
        int floor;
        int roomNumber;

        @Override
        public String toString() {
            return "Room: " + roomNumber + " Entrance: " + entrance + ", floor: " + floor;
        }
    }
}
