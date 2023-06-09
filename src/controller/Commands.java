package controller;

import java.util.Arrays;
import java.util.List;
import gameExceptions.GameException;

/**
 * Class: Commands
 * @version 1.2
 * Course: ITEC 3860 Spring 2023
 * Written: February 18, 2023
 * 
 * This class Handles commands from the user. The command is parsed, type of
 * command determined and
 * then routed to correct methods to handle the command.
 */
class Commands {

	protected static final List<Character> VALID_DIRECTIONS = Arrays.asList('W', 'N', 'S', 'E', 'U', 'D');
	protected static final List<Character> ITEM_COMMANDS = Arrays.asList('I', 'R', 'G');
	public static final int EXIT_COMMAND = 5;
	private Player player;

	/**
	 * Method Commands
	 * Constructor for the Commands class
	 * Instatiates a new player object for tracking inventory in the game
	 */
	Commands() {
		// TODO - implement Commands.Commands
		player = new Player();
//		throw new UnsupportedOperationException();
	}

	/**
	 * Method validateCommand
	 * returns an int that tells what type of command.
	 * 1 for movement (N, S, E, W, U, D)
	 * 2 for item commands (G, R, I)
	 * 3 for Look (L)
	 * 4 for Backpack (B)
	 * EXIT_COMMAND for exit (X)
	 * throws an exception for an invalid command
	 * @param cmdLine - String containing the command entered by the user
	 * @return int - the integer for the command received. If not recognized, returns 0 for an invalid command
	 * @throws GameException
	 */
	private int validateCommand(String cmdLine) throws GameException {
		// TODO - implement Commands.validateCommand

		if (VALID_DIRECTIONS.contains(cmdLine)){
			return 1;
		} else if (ITEM_COMMANDS.contains(cmdLine)){
			return 2;
		} else if (cmdLine.equalsIgnoreCase("Look") || cmdLine.equalsIgnoreCase("L")){
			return 3;
		} else if (cmdLine.equalsIgnoreCase("B")){
			return 4;
		} else if (cmdLine.equalsIgnoreCase("X")) {
			return EXIT_COMMAND;
		}
		else {
			return 0;

		}


	}

	/**
	 * Method executeCommand
	 * returns the String to be displayed to the user based on the user's command
	 * Calls the correct command method or returns the String for the command entered.
	 * throws an exception for an invalid command
	 * @param cmd - String that contains the command entered by the user
	 * @return String - the response to the command
	 * @throws GameException
	 */
	protected String executeCommand(String cmd) throws GameException {
		// TODO - implement Commands.executeCommand
		if (validateCommand(cmd) == 1){
			return move(cmd);
		} else if (validateCommand(cmd) == 2) {
			return itemCommand(cmd);
		} else if (validateCommand(cmd) == 3) {
			Room r = new Room(player.getCurRoom());
			return lookItem(cmd,r);
		} else if (validateCommand(cmd) == 4) {
			return player.printInventory();
		} else if (validateCommand(cmd) == EXIT_COMMAND){
			return "Thank you for playing the Game";

		}
		else {
			throw new GameException("Invalid Command Entered");
		}
	}

	/**
	 * Method move
	 * returns the String for the new Room the user is entering
	 * Calls Room validDirection to ensure that the direction is valid for this room.
	 * If the direction is valid,
	 * Updates the room to be visited by updating the room
	 * Updates the current Room in Player
	 * If the direction is not valid,
	 * throws an exception for an invalid direction
	 * @param cmdRoom - String that contains the command entered by the user
	 * @return String - the new room the user is moving to
	 * @throws GameException
	 */
	private String move(String cmdRoom) throws GameException {
		// TODO - implement Commands.move
		Room r = new Room(player.getCurRoom());
		r.validDirection(cmdRoom.charAt(0));
		player.setCurRoom(r.getRoomID());

		throw new GameException("Invalid Direction");
	}

	/**
	 * Method itemCommand
	 * returns the String for the Item based on the user's command
	 * Calls different methods to handle the Item interactions
	 * throws an exception for an invalid command or action,
	 * For example, item not in the room and the user tries to pick it up
	 * @param cmd - String that contains the command entered by the user
	 * @return String - the response to the user's command
	 * @throws GameException
	 */
	private String itemCommand(String cmd) throws GameException {
		// TODO - implement Commands.itemCommand
		throw new UnsupportedOperationException();
	}

	/**
	 * Method get
	 * returns the String for the item to be added to the Player's inventory
	 * Updates the room to remove the item from the room
	 * Updates Player to add item to the backpack
	 * throws an exception if the item is not in the room
	 * @param cmd - String that contains the command entered by the user
	 * @param room
	 * @return String - item has been added to inventory
	 * @throws GameException
	 */
	private String get(String cmd, Room room) throws GameException {
		// TODO - implement Commands.get
		throw new UnsupportedOperationException();
	}

	/**
	 * Method remove
	 * returns the String for dropping the item
	 * Updates the room to add the item to the room
	 * Updates the Player by removing the item from the backpack
	 * throws an exception for if Item is not in the inventory
	 * @param cmd - String that contains the command entered by the user
	 * @param room - the current Room from view.Adventure
	 * @return String - the Item has been dropped
	 * @throws GameException
	 */
	private String remove(String cmd, Room room) throws GameException {
		// TODO - implement Commands.remove
		throw new UnsupportedOperationException();
	}

	/**
	 * Method lookItem
	 * returns the String of the item or an "I don't see " the item message
	 * @param cmd - String that contains the command entered by the user
	 * @param room - the current Room from view.Adventure
	 * @return String - the String for the look command
	 * @throws GameException
	 */
	private String lookItem(String cmd, Room room) throws GameException {
		// TODO - implement Commands.lookItem

		String s = "";

		if (room.getItems().size()==0){
			return "I do not see any Items Here";
		}
		else{
			if (cmd.equalsIgnoreCase("l")){
				return room.display();
			}
		}
//		throw new UnsupportedOperationException();
		return s;
	}

}