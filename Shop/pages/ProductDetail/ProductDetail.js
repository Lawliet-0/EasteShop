// pages/ProductDetail/ProductDetail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      pno:'',
      msg:0,
      
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      let balance=options.balance
      let id=options.pno
      let price=options.price
      let name=options.name
      let num=options.num
      var app=getApp()
      let uname=app.globalData.userInfo.nickName
      console.log("当前用户为:"+uname)
      console.log("进入商品号为:"+id+"的购买页面")
      this.setData({
        pno:id,
        price:price,
        name:name,
        num:num,
        uname:uname,
        balance:balance
      })
  },
  addfun:function(){
    let that=this
    wx.request({
      url: 'http://localhost:8080/reduce',
      data:{
        isreduce:'1',
        pname:that.data.name,
        prono:that.data.pno,
        uname:that.data.uname,
        price:that.data.price,
        balance:that.data.balance
      }
    })
    console.log("购买成功!")
    
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})