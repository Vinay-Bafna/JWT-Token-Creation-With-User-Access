# JWT-Token-Creation-With-User-Access

#Note Create User Schema in MySql Workbench
spring.port=8080
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/nameOfSchema
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql= true


Register Url In PostMan:
Post Request:Select Post Form Drop Down
http://localhost:8080/api/v1/auth/register


Body Section -> Raw -> select Json paste Following:
{
    "name":"Username",
    "email":"User-Email",
    "password":"Your Encrypted Password"
}
and hit Url

output:
{
    "name": "Username",
    "email": "User-Email",
    "password": "Encrypted Password",
    "roles": [
        {
            "id": 1002,
            "name": "NORMAL_USER"
        }
    ],
    "enabled": true,
    "accountNonLocked": true,
    "username": "User-Email",
    "authorities": [
        {
            "authority": "NORMAL_USER"
        }
    ],
    "credentialsNonExpired": true,
    "accountNonExpired": true
}



login Url :
Post Request:Select Post Form Drop Down
http://localhost:8080/api/v1/auth/login
Body Section -> Raw -> select Json paste Following:

{
    "username":"User-Email",
    "password":"User-Password"
}
and hit Url

output:
{
    "token": "JWT TOKEN Here Which Contains ("Header","Payload","Verify Signature") and as in Encrypted typed"
    "user": {
        "name": "Username",
        "email": "User-Email",
        "password": "User-Encrypted Password",
        "roles": [
            {
                "id": 1002,
                "name": "NORMAL_USER"
            }
        ],
        "enabled": true,
        "accountNonLocked": true,
        "username": "User-Email",
        "authorities": [
            {
                "authority": "NORMAL_USER"
            }
        ],
        "credentialsNonExpired": true,
        "accountNonExpired": true
    }
}
