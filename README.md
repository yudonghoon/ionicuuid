# ionicuuid
ionic uuid for android10 over

# how to install
1. copy to root of your ionic project
2. In Terminal, Enter "cordova plugin add myPlugin —link"

# How to use  
uuid:any;

checkuuid()
{
(<any>window).plugins.myPlugin.drmuuid(['dummy'], 
    (data)=>{
    console.log('data', data);
    this.uuid = data;
    },
    (error)=>{
    console.log('data', error);
    },
);
}

