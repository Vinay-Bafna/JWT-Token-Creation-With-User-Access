# Following Description That You Need To Know :-  

Note Create "User Schema" in MySql Workbench

After Building SpringBoot Project Hit This Following URl's Is In Postman :-

--------------------------------------------------------------------------------------------------------
@UserRegistration Url In PostMan:

Post Request :  Select Post Form Drop Down

URl's: http://localhost:8080/api/v1/auth/register

Body Section -> Raw -> Select JSON from DropDown and Paste Following:

{

    "name":"Username", 
    
    "email":"User-Email",
    
    "password":"Your Password"
}

and hit Url.

Check IF You Are Getting Error! Which Server Port are You On Running and Try to Change It If Required! 

# Output:

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

-------------------------------------------------------------------------------------------------------


@UserLogin Url In Postman:

Post Request :  Select Post Form Drop Down

URl's: http://localhost:8080/api/v1/auth/login

Body Section -> Raw -> select Json paste Following:

{

    "username":"User-Email",
    
    "password":"User-Password"

}

and hit Url

# Output:

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
