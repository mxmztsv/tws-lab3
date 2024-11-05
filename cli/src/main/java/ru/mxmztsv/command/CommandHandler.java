package ru.mxmztsv.command;

import ru.mxmztsv.app.ClientServiceException_Exception;

import java.util.Map;

public interface CommandHandler {
    void execute(Map<Key, String> params) throws ClientServiceException_Exception;

    Command getName();
}
