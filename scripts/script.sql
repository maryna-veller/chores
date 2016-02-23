create table Account (id int NOT NULL AUTO_INCREMENT,firstname CHAR(100) NOT NULL, lastname CHAR(100) NOT NULL, email CHAR(200) NOT NULL, password CHAR(100) NOT NULL,
 PRIMARY KEY(id));
create table Chore (id int NOT NULL AUTO_INCREMENT,name CHAR(100) NOT NULL, PRIMARY KEY(id));

create table ChoreGroup(id int NOT NULL AUTO_INCREMENT, name CHAR(100) NOT NULL, PRIMARY KEY(id));

create table ChoreInGroup(groupId int NOT NULL, choreId int NOT NULL, PRIMARY KEY(groupId, choreId),
FOREIGN KEY (groupId)  
        REFERENCES ChoreGroup(id),

FOREIGN KEY (choreId)
        REFERENCES Chore(id)
);
