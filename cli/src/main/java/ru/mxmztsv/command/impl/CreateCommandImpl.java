package ru.mxmztsv.command.impl;

import lombok.SneakyThrows;
import ru.mxmztsv.app.ClientServiceException_Exception;
import ru.mxmztsv.app.ClientServiceImpl;
import ru.mxmztsv.app.model.ClientResponse;
import ru.mxmztsv.command.Command;
import ru.mxmztsv.command.CommandHandler;
import ru.mxmztsv.command.Key;
import ru.mxmztsv.command.mapper.ClientMapper;

import java.util.Map;

public class CreateCommandImpl implements CommandHandler {

    private final ClientServiceImpl clientService;

    public CreateCommandImpl(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @SneakyThrows
    @Override
    public void execute(Map<Key, String> params) throws ClientServiceException_Exception {
        ClientResponse clientResponse =
                clientService.create(ClientMapper.mapToRequestCreate(ClientMapper.mapKeysToClient(params)));
        System.out.println(ClientMapper.mapToString(clientResponse));
    }

    @Override
    public Command getName() {
        return Command.CREATE;
    }
}
