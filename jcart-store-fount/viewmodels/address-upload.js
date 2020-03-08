var app = new Vue({
    el: '#app',
    data: {
        addressId:'',
        receiverName:'',
        receiverMobile:'',
        content:'',
        tag:''
    },
    mounted(){
       console.log('view mounted')     
       var url = new URL(location.href);
       this.addressId = url.searchParams.get("addressId");
       if (!this.addressId) {
           alert('addressId is null');
           return;
       }
       this.getAddressById();
    },
    methods: {
        handleUploadAddressClick() {
            console.log('upload address click')
            this.addressCreate();
        },
        UploadAddressClick() {
            axios.post('/address/upload', {
                receiverName: this.receiverName,
                receiverMobile: this.receiverMobile,
                content: this.content,
                tag: this.tag,
            }).then(function (response) {
                console.log(response)
                alert('注册成功');
            }).catch(function (error) {
                console.log(error)
            })
        },
        getAddressById(){
            axios.get('/address/getByAddress',{
                params:{
                    addressId:this.addressId
                }
            }).then(function (response) {
                console.log(response)
                app.receiverMobile=response.data.receiverMobile;
                app.receiverName=response.data.receiverName;
                app.tag=response.data.tag;
                app.content=response.data.content;
            })
        }
    },

})