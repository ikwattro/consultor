package com.ikwattro.extension.consultor;

import com.fasterxml.jackson.annotation.*;

public class InversionDefinition
{
    String label = "";
    String direction = "";
    String type = "" ;

    public String getLabel()
    {
        return label;
    }

    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("label")
    public void setLabel(String label)
    {
        this.label = label;

    }

    public String getDirection()
    {
        return direction;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return "Label => " + this.label;
    }
}