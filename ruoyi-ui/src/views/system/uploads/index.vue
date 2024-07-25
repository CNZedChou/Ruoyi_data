<template>
  <div class="app-container">
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="200px">
      <el-form-item label="请输入新增加密数据信息" prop="field101">
        <el-button type="primary" icon="el-icon-plus" @click="handleAdd">新增</el-button>
      </el-form-item>
    </el-form>

    <el-dialog title="新增信息" :visible.sync="dialogVisible" width="500px">
      <el-form :model="form" :rules="formRules" ref="form" label-width="100px">
        <el-form-item label="企业名称" prop="companyName">
          <el-input v-model="form.companyName"></el-input>
        </el-form-item>
        <el-form-item label="数据来源" prop="dataSource">
          <el-select v-model="form.dataSource" placeholder="请选择数据来源">
            <el-option label="主链" value="main"></el-option>
            <el-option label="企业私链" value="private"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="数据类别" prop="dataType">
          <el-select v-model="form.dataType" placeholder="请选择数据类别">
            <el-option label="电能" value="electric"></el-option>
            <el-option label="核能" value="nuclear"></el-option>
            <el-option label="氢气" value="hydrogen"></el-option>
            <el-option label="天然气" value="natural_gas"></el-option>
            <el-option label="其他" value="other"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="加密数据" prop="encryptedData">
          <el-upload
            class="upload-demo"
            action="https://jsonplaceholder.typicode.com/posts/"
            :on-success="handleUploadSuccess"
            :before-upload="beforeUpload">
            <el-button size="small" type="primary">点击上传</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label="备注">
          <el-input type="textarea" v-model="form.remarks"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm('form')">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      formData: {
        field101: undefined,
      },
      rules: {},
      dialogVisible: false,
      form: {
        companyName: '',
        dataSource: '',
        dataType: '',
        encryptedData: null,
        remarks: ''
      },
      formRules: {
        companyName: [{ required: true, message: '请输入企业名称', trigger: 'blur' }],
        dataSource: [{ required: true, message: '请选择数据来源', trigger: 'change' }],
        dataType: [{ required: true, message: '请选择数据类别', trigger: 'change' }],
        encryptedData: [{ required: true, message: '请上传加密数据', trigger: 'change' }]
      }
    }
  },
  methods: {
    handleAdd() {
      this.dialogVisible = true
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log('submit!', this.form)
          this.dialogVisible = false
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    handleUploadSuccess(response, file, fileList) {
      this.form.encryptedData = file
    },
    beforeUpload(file) {
      // 可以添加文件上传前的验证逻辑
      return true
    }
  }
}
</script>

<style>
.app-container {
  padding: 20px;
}
</style>
