## Mock Server for Rewards Service

**Run Server**

`docker-compose up`

http://local.bskyb.com:3000/rewards?subscriptions=[SUBSCRIPTION_LIST]&accountNumber=[ACC_NUMBER]

**MOCK TEST MODES (REWARDS)**

- Technical failure Exception
http://localhost:3000/rewards?subscriptions=[SUBSCRIPTION_LIST]&accountNumber=[ACC_NUMBER]&testMode=FAILURE

- Invalid account Number exception
http://localhost:3000/rewards?subscriptions=[SUBSCRIPTION_LIST]&accountNumber=[ACC_NUMBER]&testMode=INVALID_ACCOUNT

**Android Setup**

IP ADDRESS FOR MOCK SERVER: `10.0.2.2`
