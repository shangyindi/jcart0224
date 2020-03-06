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
        createTime:'',
        administrationId:''
    },
    mounted() {
        console.log('view mounted');
        var url = new URL(location.href);
        this.administrationId = url.searchParams.get("administrationId");
        if (!this.administrationId) {
            alert('administrationId is null')
            return;
        }
        this.getAdministrationId();
    },
    methods: {
        handleUploadClick() {
            console.log('upload click');
            this.UploadProduct();
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
        getAdministrationId() {
            axios.get('/administrator/getByAdministrationId',{
                params:{
                    administrationId:this.administrationId
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.realName=response.data.realName;
                    app.username=response.data.username;
                    app.email=response.data.email;
                    app.createTime=response.data.createTime;
                    app.selectedStatus=response.data.status;
                    app.avatarUrl=response.data.avatarUrl;
                    app.administrationId=response.data.administrationId
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        UploadProduct(){
            axios.post('/administrator/upload',{
                administrationId:this.administrationId,
                username:this.username,
                realName:this.realName,
                createTime:this.createTime,
                email:this.email,
                status:this.selectedStatus
            }).then(function (response) {
                console.log(response)
                alert('更新成功')
            }).catch(function (error) {
                console.log(error)
            })
        }
    }
})