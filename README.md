Two dummy user created for testing. 
    John id: 1
    Alex id: 2
    
Routes 
**Deposit**
POST /{userid}/deposit?amount=

**Withdraw**
POST /{userid}/withdraw?amount=

**Get all transactions of user**
GET /{userid}/transactions

_Filter by type_
GET /{userid}/transactions/deposit
GET /{userid}/transactions/withdraw

**Transfer**
POST /transfer?transferFrom= &transferTo= & transferAmount=
