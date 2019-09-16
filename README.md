# react-native-riilcash-sdk

Node library for connect riilcash network

**This package is still a work in progress** 


## Installation

```bash
$ npm install react-native-riilcash-sdk
```
or
```bash
$ yarn add react-native-riilcash-sdk
```


**Creating riilcash instance**

instance riilcash
```js
import riilcash from 'react-native-riilcash-sdk'

/* Create new react-native-riilcash-sdk instance login*/
const riilcash = new riilcash()

/* Create new react-native-riilcash-sdk instance other login*/
const riilcash = new riilcash('token')
```

**use**

Returns a promise which resolves into an object containing the current request.


not use token
```js
var riilcash = new riilcash()
asyncCall()

async asyncCall() {
var result = await riilcash.login({name:"ca",password:1})
}
```


use token
```js
var riilcash = new riilcash('exxxxxxxx') /* use token */
asyncCall()

async asyncCall() {
var result = await riilcash.sendMoney({id:1,amount:1.00})
}
```



