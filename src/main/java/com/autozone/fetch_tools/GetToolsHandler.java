package com.autozone.fetch_tools;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class GetToolsHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final Gson mapper = new GsonBuilder().setPrettyPrinting().create();
    private final ToolsRepository toolRepo = new ToolsRepository();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context) {
        LambdaLogger logger = context.getLogger();

        logger.log("RECEIVED EVENT: " + requestEvent);

        List<Tool> tools = toolRepo.getAllTools();
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setBody(mapper.toJson(tools));

        return responseEvent;
    }
}
