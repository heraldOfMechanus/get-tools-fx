package com.autozone.fetch_tools;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;

public class ToolsRepository {

    private final DynamoDBMapper dbReader;

    public ToolsRepository() {
        this.dbReader = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient());
    }

    public List<Tool> getAllTools() { return dbReader.scan(Tool.class, new DynamoDBScanExpression()); }
}
