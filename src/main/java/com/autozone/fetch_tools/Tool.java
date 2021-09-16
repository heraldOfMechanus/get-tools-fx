package com.autozone.fetch_tools;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

import java.util.List;


@Data
@DynamoDBTable(tableName = "toolsapi")
public class Tool {

    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private double cost;

    @DynamoDBAttribute
    private List<String> materials;
}
