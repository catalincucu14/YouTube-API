CREATE TABLE Users (
    USER_ID SERIAL NOT NULL,
    FIRST_NAME VARCHAR(25) NOT NULL,
    LAST_NAME VARCHAR(25) NOT NULL,
    MAIL VARCHAR(50) NOT NULL,
    USERNAME VARCHAR(25) NOT NULL,
    PASSWORD TEXT NOT NULL,
    PRIMARY KEY (USER_ID),
    UNIQUE (MAIL),
    UNIQUE (USERNAME)
);

CREATE TABLE Videos (
    VIDEO_ID SERIAL NOT NULL,
    USER_ID INT NOT NULL,
    TITLE VARCHAR(100) NOT NULL,
    DESCRIPTION VARCHAR(500) NOT NULL,
    VIEWS INT NOT NULL,
    UPLOAD_DATE DATE NOT NULL,
    PRIMARY KEY (VIDEO_ID),
    FOREIGN KEY (USER_ID) REFERENCES Users (USER_ID)
);

CREATE TABLE Comments (
    COMMENT_ID SERIAL NOT NULL,
    USER_ID INT NOT NULL,
    VIDEO_ID INT NOT NULL,
    CONTENT VARCHAR(250) NOT NULL,
    POST_DATE  DATE NOT NULL,
    PRIMARY KEY (COMMENT_ID),
    FOREIGN KEY (USER_ID) REFERENCES Users (USER_ID),
    FOREIGN KEY (VIDEO_ID) REFERENCES Videos (VIDEO_ID)
);

CREATE TABLE Likes (
    LIKE_ID SERIAL NOT NULL,
    USER_ID INT NOT NULL,
    VIDEO_ID INT NOT NULL,
    LIKE_DATE  DATE NOT NULL,
    PRIMARY KEY (LIKE_ID),
    FOREIGN KEY (USER_ID) REFERENCES Users (USER_ID),
    FOREIGN KEY (VIDEO_ID) REFERENCES Videos (VIDEO_ID),
    UNIQUE (USER_ID, VIDEO_ID)
);
