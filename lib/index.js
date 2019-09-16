import { NativeModules, DeviceEventEmitter } from 'react-native';
RNRiilcashOffline = NativeModules.RNRiilcashOffline;

'use strict'
var axios = require('axios')
var qs = require('qs')

var Riilcash =  function(token){
    this.server = "https://common.riilcash.com"
    this.header = token?{headers:{'Content-Type':'application/x-www-form-urlencoded','acces_token': token}}:
    {headers:{'Content-Type':'application/x-www-form-urlencoded'}}
}

Riilcash.prototype.peoples = async  function(params){
    try {
        const response = await axios.post(`${this.server}/peoples`,qs.stringify(params),this.header)
        return response.data 
      } catch (err) {
        return err
      }
    
}


Riilcash.prototype.login = async  function(params){
    try {
        const response = await axios.post(`${this.server}/peoples/login`,qs.stringify(params),this.header)
        return response.data 
      } catch (err) {
        return err
      }
  }

Riilcash.prototype.masterCountry= async function(){
    try {
        const response = await axios.get(`${this.server}/master/country`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.masterCurrency= async function(){
    try {
        const response = await axios.get(`${this.server}/master/currency`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.masterMto= async function(){
    try {
        const response = await axios.get(`${this.server}/master/mto`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.masterBank= async function(){
    try {
        const response = await axios.get(`${this.server}/master/bank`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.masterProvider= async function(){
    try {
        const response = await axios.get(`${this.server}/master/provider`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.peoplesAll= async function(){
    try {
        const response = await axios.get(`${this.server}/peoples`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.peopleById= async function(publicId){
    try {
        const response = await axios.get(`${this.server}/peoples/${publicId}`,this.header)
        return response.data 
      } catch (err) {
        return err
      } 
}

Riilcash.prototype.checkAccount= async function(publicId){
    try {
        const response = await axios.get(`${this.server}/check_account/${publicId}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.peopleByName= async function(name){
    try {
        const response = await axios.get(`${this.server}/peopleByName/${name}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.peopleByNameAndParent= async function(name,parent_id){
    try {
        const response = await axios.get(`${this.server}/peopleByName/${name}/${parent_id}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.peopleByParent= async function(parent_id){
    try {
        const response = await axios.get(`${this.server}/peopleByParent/${parent_id}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}


Riilcash.prototype.forgotPassword= async function(name){
    try {
        const response = await axios.get(`${this.server}/peoples/forgotPassword/${name}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.singlePeopleByName= async function(name){
    try {
        const response = await axios.get(`${this.server}/singlePeopleByName/${name}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}


Riilcash.prototype.deposits= async function(params){
    try {
        const response = await axios.post(`${this.server}/deposits`,qs.stringify(params),this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.getDeposits= async function(name){
    try {
        const response = await axios.get(`${this.server}/deposits/${name}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}


Riilcash.prototype.depositsProcess= async function(unique_code){
    try {
        const response = await axios.post(`${this.server}/deposits/process/ ${unique_code}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}


Riilcash.prototype.withdrawals= async function(params){
    try {
        const response = await axios.post(`${this.server}/withdrawals`,qs.stringify(params),this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.getWithdrawals= async function(name){
    try {
        const response = await axios.get(`${this.server}/withdrawals/${name}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.withdrawalsProcess= async function(unique_code){
    try {
        const response = await axios.post(`${this.server}/withdrawals/process/ ${unique_code}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}


Riilcash.prototype.bankTransfers= async function(account_id){
    try {
        const response = await axios.get(`${this.server}/bank_transfers/${account_id}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.bankTransfersProcess= async function(unique_code){
    try {
        const response = await axios.post(`${this.server}/bank_transfers/process/ ${unique_code}`,this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.createPayment= async function(params){
    try {
        const response = await axios.post(`${this.server}/create_payment`,qs.stringify(params),this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.sendMoney= async function(params){
    try {
        const response = await axios.post(`${this.server}/send_money`,qs.stringify(params),this.header)
        return response.data 
      } catch (err) {
        return err
      }
}

Riilcash.prototype.insert = async function(params){
  try{
    const data = RNRiilcashOffline.insert(params.amount, params.currency, params.dest_account_id, params.method, params.unique_code, params.source_account_pub)
    return data
  }
  catch (err){
    return err
  }
}

Riilcash.prototype.delete = async function(localId){
  try{
    const data = RNRiilcashOffline.delete(localId)
    return data
  }
  catch (err){
    return err
  }
}

Riilcash.prototype.getAll = async function(){
  try{
    const data = RNRiilcashOffline.getAll()
    return data
  }
  catch (err){
    return err
  }
}


module.exports = Riilcash



