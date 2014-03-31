package com.dean.test;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

public class TwoDotTwo {

	public static void main(String[] args) {
		
		MongoConnection conn = null;
		
		try {
			conn = new MongoConnection("localhost", "students");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		DBCollection col = conn.getDatabase().getCollection("grades");
		QueryBuilder query = QueryBuilder.start("type").is("homework");
		
		DBCursor cursor = col.find(query.get()).sort(new BasicDBObject("student_id",1).append("score",1));
		
		try{
			int studentId = -1;
			while(cursor.hasNext()){
				DBObject me = cursor.next();
				if(studentId == (Integer) me.get("student_id")){
					System.out.println(me);
				}
				else{
					System.out.println(me + " changed! remove me");
					col.remove(me);
				}
				
				studentId = (Integer) me.get("student_id");
			}
		}
		finally{
			cursor.close();
		}

	}

}
