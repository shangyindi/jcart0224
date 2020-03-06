var app = new Vue({
    el: '#app',
    data: {
        username:'',
        password:'',
        realName:'',
        email:'',
        selectedStatus: 1,
        statuses: [
            { value: 0, label: '禁用' },
            { value: 1, label: '启用' },
        ],
        mainFileList: [],
        avatarUrl:'',
        createTime:''
    },
    methods: {
        handleCreateClick() {
            console.log('create click');
            this.createProduct();
        },
        handleOnMainChange(val) {
            this.selectedMainPic = val.raw;
        },
        handleUploadMainClick() {
            console.log('upload main pic click');
            this.uploadMainImage();
        },
        uploadMainImage() {
            var formData = new FormData();
            formData.append("image", this.selectedMainPic);

            axios.post('/image/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.avatarUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
        },
        createProduct() {
            axios.post('/administrator/create', {
                username:this.username,
                password:this.password,
                realName:this.realName,
                email:this.email,
                status:this.selectedStatus,
                avatarUrl:this.avatarUrl,
                createTime:this.createTime
            })
                .then(function (response) {
                    console.log(response);
                    alert('创建成功');
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})