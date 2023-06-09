package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ArrayList;
import  model.RoomDB;
import   model.ItemDB;
import  gameExceptions.GameException;

/**
 * Class: Room
 * * @version 1.2
 *  * Course: ITEC 3860 Spring 2023
 *  * Written: February 18, 2023
 * This class  handles the Room interactions. This class contains the roomID,
 * name, description
 * ArrayLists Exit and Item as well as a boolean value to determine if the user has visited the room.
 * Finally, it contains a reference to the current map that is read from GameController.
 */
public class Room {

	private int roomID;
	private String name;
	private String description;
	private String directions;
	private ArrayList<Integer> items;
	private boolean visited;
	private Collection<ArrayList<Exit>> exits;
	private RoomDB rdb;
	private ItemDB idb;

	public int getRoomID() {
		return this.roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getDirections() {
		return this.directions;
	}

	public ArrayList<Integer> getItems() {
		return this.items;
	}

	public void setItems(ArrayList<Integer> items) {
		this.items = items;
	}

	public boolean isVisited() {
		return this.visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Collection<ArrayList<Exit>> getExits() {
		return this.exits;
	}

	public void setExits(Collection<ArrayList<Exit>> exits) {
		this.exits = exits;
	}

	/**
	 * Method Room
	 * Constructor for the Room class
	 * Initializes exits and items ArrayLists and gets the current map.
	 */
	public Room() throws GameException {
		// TODO - implement Room.Room

		this.exits = getExits();
		this.visited = false;
		this.items = getItems();
//		throw new UnsupportedOperationException();
	}

	/**
	 * Room constructor
	 * constructs the room object with the given ID
	 * @param id
	 */
	public Room(int id) throws GameException {
		// TODO - implement Room.Room
		retrieveByID(id);

		setRoomID(id);
		setName(rdb.getRoom(id).name);
		setDescription(rdb.getRoom(id).description);
		setDirections(rdb.getRoom(id).directions);
		setItems(rdb.getRoom(id).items);
		setVisited(rdb.getRoom(id).visited);

//		throw new UnsupportedOperationException();
	}

	/**
	 * Method display
	 * Builds a String representation of the current room
	 * Calls buildItems, buildDescription, and displayExits to build this String
	 * @return String - the current room display String
	 * @throws GameException if the Item String cannot be built
	 */
	public String display() throws GameException {
//		 TODO - implement Room.display
		return buildItems() + buildDescription()+ displayExits();
//		throw new UnsupportedOperationException();
	}

	/**
	 * Method buildDescription
	 * Builds a String of the description
	 * @return String - the current room description text
	 */
	private String buildDescription() {
		// TODO - implement Room.buildDescription
		return getDescription();
//		throw new UnsupportedOperationException();
	}

	/**
	 * Method buildItems
	 * Builds a String of the items in the room
	 * @return String - the current room items text
	 * @throws GameException
	 */
	private String buildItems() throws GameException {
		// TODO - implement Room.buildItem
		String s = "";
		ArrayList<Item> a = getRoomItems();
		for(Item i: a){
			s+=i.getItemDescription();
		}
		return s;
//		throw new UnsupportedOperationException();
	}

	/**
	 * Method removeItem
	 * Removes an item from the room. Removes it and calls updateRoom to save the changes
	 * @param item - the Item to remove
	 */
	public void removeItem(Item item) throws GameException {
		// TODO - implement Room.removeItem
		throw new UnsupportedOperationException();
	}

	/**
	 * Method dropItem
	 * Adds an item from the room. Adds it and calls updateRoom to save the changes
	 * @param item - the Item to add
	 */
	public void dropItem(Item item) throws GameException {
		// TODO - implement Room.dropItem
		throw new UnsupportedOperationException();
	}

	/**
	 * Method updateRoom
	 * Calls RoomDB updateRoom(this) to save the current room in the map
	 */
	public void updateRoom() throws GameException {
		// TODO - implement Room.updateRoom

		throw new UnsupportedOperationException();
	}

	/**
	 * Method displayExits
	 * Builds a String of the exits in the room
	 * @return String - the current room exits text
	 */
	private String displayExits() {
		// TODO - implement Room.displayExits
		System.out.println(getExits());
		throw new UnsupportedOperationException();
	}

	/**
	 * Method retrieveByID
	 * Retrieves the requested Room from RoomDB. Sets its values into the current Room and returns it
	 * @param roomNum ID of the room to retrieve
	 * @return Room - the requested Room
	 * @throws GameException if the room cannot be found
	 */
	public Room retrieveByID(int roomNum) throws GameException {
		// TODO - implement Room.retrieveByID
		//RoomDB rdb = new RoomDB();
		Room o = rdb.getRoom(roomNum);
		System.out.println(o);
		return o;
//		throw new UnsupportedOperationException();
	}

	/**
	 * Method validDirection
	 * Determines if the direction entered by the user is valid for this room
	 * Throws an exception if this is invalid
	 * @param cmd - The direction the user wants to move
	 * @return int - the ID of the destination room
	 * @throws GameException if the direction chosen is not valid
	 */
	public int validDirection(char cmd) throws GameException {
		// TODO - implement Room.validDirection
		int i = 0;
		Room rm = new Room(roomID);
		Collection<ArrayList<Exit>> ex = rm.getExits();
		for (ArrayList<Exit> e: ex){
			if (e.get(i).getDirection().substring(0, 1) == (String.valueOf(cmd))){
				return e.get(i).getDestination();
			}

			if (i == ex.size()){
				throw new GameException("Room not Found");
			}
		}

		throw new UnsupportedOperationException();
	}

	/**
	 * Method: getRoomItems
	 * 
	 * This method calls RoomDB to get the items that are in the current room.
	 * @return ArrayList Item - the items in the room
	 * @throws GameException if the list of items cannot be built
	 */
	public ArrayList<Item> getRoomItems() throws GameException {
		// TODO - implement Room.getRoomItems
		return rdb.getItems(getRoomID());
//		throw new UnsupportedOperationException();
	}

	/**
	 * Method setName
	 * setter for room name
	 * @param name - the name to be set
	 */
	public void setName(String name) throws GameException {
		this.name = name;
	}

	/**
	 * Method setDescription
	 * setter for room description
	 * @param description - the description to be set
	 */
	public void setDescription(String description) throws GameException {
		this.description = description;
	}


	@Override()
	public String toString() {
		return "\nRoom " + roomID +
				"\nRoom name = " + name  +
				"\ndescription='" + description +
				"\ndirections='" + directions +
				"\nexits='" + exits + '\'';
	}

}