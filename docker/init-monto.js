// Create user
dbAdmin = db.getSiblingDB("admin");
dbAdmin.createUser({
    user: "spring_root",
    pwd: "1234",
    roles: [{ role: "userAdminAnyDatabase", db: "admin" }],
    mechanisms: ["SCRAM-SHA-1"],
});

// Authenticate user
dbAdmin.auth({
    user: "spring_admin",
    pwd: "1234",
    mechanisms: ["SCRAM-SHA-1"],
    roles: [{ role: "userAdminAnyDatabase", db: "spring_db" }, { role: "readWrite", db: "spring_db" }],
    digestPassword: true,
});


// Create DB and collection
db = new Mongo().getDB("spring_db");
db.getSiblingDB('spring_db');
db.createUser({
    user: "spring_user",
    pwd: "1234",
    roles: ["readWrite"],
});


