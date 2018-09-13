var express = require('express');
var app = express();

const rewardCodes = {
    'SPORTS': 'CHAMPIONS_LEAGUE_FINAL_TICKET',
    'KIDS': 'N/A',
    'MUSIC': 'KARAOKE_PRO_MICROPHONE',
    'NEWS': 'N/A',
    'MOVIES': 'PIRATES_OF_THE_CARIBBEAN_COLLECTION'
};

const getRewards = (req, testMode) => {
    if (testMode === "CUSTOMER_ELIGIBLE") {
        const subscriptions = req.query.subscriptions.split(',');
        return subscriptions.map(sub => ({ code: rewardCodes[sub] }));
    }
    return [];
};

const eligibilityResponse = (testMode) => {
    switch(testMode) {
        case "FAILURE": {
            return {
                output: 'Technical failure exception',
            };
        };
        case "INVALID_ACCOUNT": {
            return {
                output: 'Invalid account Number',
            };
        };
        default: {
            return { output: testMode };
        }
    }
};

 
app.get('/rewards', (req, res) => {
   const testMode = req.query.testMode || 'CUSTOMER_ELIGIBLE';
   const eligibility = eligibilityResponse(testMode);
   const { accountNumber, subscriptions } = req.query || {};
   const rewards = getRewards(req, testMode);
    
   if (accountNumber && subscriptions) {
       const response = Object.assign({}, { eligibility }, { rewards });
       res.send(response);
   } else {
       const response = Object.assign({}, { eligibility }, { rewards });
       res.send(response);
   }
});

app.listen(3000);