
# Note Create User Schema in MySql Workbench

After Building SpringBoot Project hits this Following URl's:

UserRegistration Url In PostMan:

Post Request:Select Post Form Drop Down

http://localhost:8080/api/v1/auth/register

Body Section -> Raw -> select Json paste Following:
{
    "name":"Username",
    "email":"User-Email",
    "password":"Your Password"
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
