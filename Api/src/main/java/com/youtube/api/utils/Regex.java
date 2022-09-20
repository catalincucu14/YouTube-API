package com.youtube.api.utils;

public class Regex {
    public static final String Mail = "^(?=^.{10,50}$)(\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+)$";

    public static final String Name = "^([\\d\\w ,.'\\-()_]*)$";

    public static final String Username = "^([\\d\\w]*)$";

    public static final String Title = "^([\\d\\w .\\-.;,?!#$%&*()[]{}]*)$";

    public static final String Password = "^(?=.*?[A-Z])(?=.*?[a-z]).{8,40}$";
}
