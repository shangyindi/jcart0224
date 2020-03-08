var app = new Vue({
    el: '#app',
    data: {
        receiverName:'',
        receiverMobile:'',
        content:'',
        tag:''
    },
    methods: {
        handleAddressClick() {
            console.log('address click')
            this.addressCreate();
        },
        addressCreate() {
            axios.post('/address/create', {
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
        }
    },

})