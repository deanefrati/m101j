package com.dean.test;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoConnection {
	
	private MongoClient client;
	private DB database;
	private DBCollection collection;
	
	public MongoConnection(String host, String DB) throws UnknownHostException{
		System.out.println("Attempting to connect to host: " + host);
		this.client = new MongoClient(host);
		System.out.println("Changing database to: " + DB);
		this.database = client.getDB(DB);	
	}

	public MongoClient getClient() {
		return client;
	}

	public void setClient(MongoClient client) {
		this.client = client;
	}

	public DB getDatabase() {
		return database;
	}

	public void setDatabase(DB database) {
		this.database = database;
	}

	public DBCollection getCollection() {
		return collection;
	}

	public void setCollection(DBCollection collection) {
		this.collection = collection;
	}
	
	
}
