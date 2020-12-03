// pages/Product/Product.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pno:'',
    msg:'',
    value: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  onChange: function(e) {
    this.setData({
      value: e.detail,
    });
  },
  onSearch: function(e){
    let that=this
    wx.request({
      url: 'http://localhost:8080/search',
      data:{
        name:that.data.value
      },
      method: 'get',
      header: {
        'content-type':'application/json' 
      },
    
      success: function (res){
        console.log(res)
        if(res.data.name!=null){
            console.log("存在该商品");
        wx.request({
          url: 'http://localhost:8080/seaApi',
          data: {
            name:res.data.name
          },
          method: 'get',
          header: {
            'content-type':'application/json' 
          },
          success: function (res) {
            console.log(res)
            console.log("编号为:"+res.data.pno)
            console.log("单价为:"+res.data.price)
            console.log("商品名称为:"+res.data.name)
            console.log("商品数量为:"+res.data.num)
            that.setData({
              pno:res.data.pno,
              price:res.data.price,
              name:res.data.name,
              num:res.data.num
            })
            wx.navigateTo({
              url: '../ProductDetail/ProductDetail?pno='+that.data.pno+'&price='+that.data.price+'&name='+that.data.name+'&num='+that.data.num+'' 
            })     
          },
          fail: function (res) {
            console.log("反馈未提交，请检查网络");
          }
        })    
        }
        else{
          wx.showToast({
            title: "暂无此商品",
          });
        }
      }
    })
  },
  bindViewTap: function(e) {
    var app=getApp()
    let uname=app.globalData.userInfo.nickName
    let pno=e.currentTarget.id
    console.log("序号为"+pno)
    let that=this;
    wx.request({
      url: 'http://localhost:8080/det',
      data: {
        name:e.currentTarget.id,
        uname:uname
      },
      method: 'get',
      header: {
        'content-type':'application/json' 
      },
      success: function (res) {
        console.log(res)
        console.log("单价为:"+res.data.price)
        console.log("商品名称为:"+res.data.name)
        console.log("商品数量为:"+res.data.num)
        console.log("当前余额为:"+res.data.balance)
        let t=res.data.data
        that.setData({
          price:res.data.price,
          name:res.data.name,
          num:res.data.num,
          balance:res.data.balance
        })
        wx.navigateTo({
          url: '../ProductDetail/ProductDetail?pno='+pno+'&price='+that.data.price+'&name='+that.data.name+'&num='+that.data.num+'&balance='+that.data.balance+'' 
        })     
      },
      fail: function (res) {
        console.log("反馈未提交，请检查网络");
      }
    })
   
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