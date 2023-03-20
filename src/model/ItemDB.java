package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Scanner;

import  controller.Item;
import  gameExceptions.GameException;

/**
 * Class: ItemDB
 * @version 1.2
 * Course: ITEC 3860 Spring 2023
 * Written: February 18, 2023
 * This class   Holds the Item data for mini game 2. Contains an ArrayList Item
 * This allows the other classes to request these items.
 */
public class ItemDB {

	private Collection<ArrayList<Item>> items;
	public static ItemDB instance;

	/**
	 * Method getInstance
	 * This is a static method to implement the singleton pattern. This allows the other objects to get a reference
	 * to this class and ensure that they have the same reference. This is required since we are storing the Items in
	 * ArrayList and not in a database. THis ensures that we have the correct persistence objects.
	 * 
	 * NOTE: for your project and for mini3, if we do mini3, a Singleton is not needed or desired.
	 * The singleton is to save the in memory data for the game
	 * 
	 * If instance is null, the private constructor is called. If it is not, it simply returns the instance
	 * @return RoomDB - the current RoomDB object.
	 */
	public static ItemDB getInstance() throws GameException {
		return instance;
	}

	/**
	 * private ItemDB constructor
	 * This is private to implement the singleton pattern. Class can only be instantiated in this class.
	 */
	private ItemDB() throws GameException {
		// TODO - implement ItemDB.ItemDB
//		throw new UnsupportedOperationException();
	}

	/**
	 * Method getItem
	 * Returns the Item requested by the ID. Only used in readRooms
	 * @param id - the ID of the item requested.
	 * @return Item
	 * @throws GameException if the item ID cannot be found
	 */
	public Item getItem(int id) throws GameException {
		// TODO - implement ItemDB.getItem
		return itemsArrayList.get(id-1);
//		throw new UnsupportedOperationException();
	}

	/**
	 * Method readItems
	 * Reads the Items text file to build the rooms
	 * throws an exception if the text file not found
	 */
	private ArrayList<Item> itemsArrayList = new ArrayList<>();
	public void readItems() throws GameException {
		// TODO - implement ItemDB.readItems
			File file = new File("items.txt");
			try {
				Scanner scan = new Scanner(file);

				while (scan.hasNextLine()) {
					String id = scan.nextLine();
					int itemID = Integer.parseInt(id);
					String itemName = scan.nextLine();
					String description = scan.nextLine();

					// Creating an arrayList of exits to be added to the Room object
					Item item = new Item();
					item.setItemID(itemID);
					item.setItemName(itemName);
					item.setItemDescription(description);

					itemsArrayList.add(item);

				}
				System.out.println(itemsArrayList);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
//		throw new UnsupportedOperationException();
	}
