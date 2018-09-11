var express = require('express');
var app = express();

const eligibilityResponse = (testMode) => {
    switch(testMode) {
        case "FAILURE": {
            return {
                eligibility: 'Technical failure exception',
                error: {
                    message: 'Service technical failure'
                }
            };
        };
        case "INVALID_ACCOUNT": {
            return {
                eligibility: 'Invalid account Number',
                error: {
                    message: 'The Supplied account number is invalid'
                }
            };
        };
        default: {
            return { eligibility: testMode };
        }
    }
};

const rewardCodes = {
    'SPORTS': 'CHAMPIONS_LEAGUE_FINAL_TICKET',
    'KIDS': 'N/A',
    'MUSIC': 'KARAOKE_PRO_MICROPHONE',
    'NEWS': 'N/A',
    'MOVIES': 'PIRATES_OF_THE_CARIBBEAN_COLLECTION'
};
 
app.get('/rewards', (req, res) => {
   const eligibilty = eligibilityResponse(req.query.testMode || 'CUSTOMER_ELIGIBLE');
   const { accountNumber, subscriptions } = req.query || {};
   console.log(req.query);
    
   if (accountNumber && subscriptions) {
       const subscriptions = req.query.subscriptions.split(',');
       const rewards = subscriptions.map(sub => ({ code: rewardCodes[sub] }));
       res.send(Object.assign({}, eligibilty, { rewards }));
   } else {
       res.send(eligibilty);
   }
});

app.get('/auth/get-customer', (req, res) => {
    if (req.query.testMode === 'ALL') {
        res.send({ accountNumber: '987654321', subscriptions: rewardCodes.keys() });
    } else if (req.query.testMode === 'NONE' ){
        res.send({ accountNumber: '987654321', subscriptions: ['KIDS', 'NEWS'] });
    } else {
        res.send({ accountNumber: '987654321', subscriptions: req.query.subscriptions.split(',') });
    }
 });
 
app.listen(3000);