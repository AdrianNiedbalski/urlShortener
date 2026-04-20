package org.urlshortener.dto;

import lombok.Data;

@Data
public class InputData {
    public Command command;
    public String url;

    public InputData(Command command, String url) {
        this.command = command;
        this.url = url;
    }
}
