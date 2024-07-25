<template>
  <div>
    <el-dialog v-bind="$attrs" v-on="$listeners" @open="onOpen" @close="onClose" title="Dialog Title">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-form-item label-width="120px" label="企业名称" prop="field102">
          <el-input v-model="formData.field102" placeholder="请输入企业名称" clearable :style="{width: '100%'}">
          </el-input>
        </el-form-item>
        <el-form-item label-width="120px" label="数据来源" prop="field105">
          <el-select v-model="formData.field105" placeholder="请选择数据来源" clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in field105Options" :key="index" :label="item.label"
              :value="item.value" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label-width="120px" label="数据类型" prop="field104">
          <el-select v-model="formData.field104" placeholder="请选择数据类型" clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in field104Options" :key="index" :label="item.label"
              :value="item.value" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label-width="120px" label="加密数据上传" prop="field106" required>
          <el-upload ref="field106" :file-list="field106fileList" :action="field106Action"
            :before-upload="field106BeforeUpload">
            <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
          </el-upload>
        </el-form-item>
        <el-form-item label-width="120px" label="备注" prop="field107">
          <el-input v-model="formData.field107" placeholder="请输入备注" clearable :style="{width: '100%'}">
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="handleConfirm">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  inheritAttrs: false,
  components: {},
  props: [],
  data() {
    return {
      formData: {
        field102: undefined,
        field105: undefined,
        field104: undefined,
        field106: null,
        field107: undefined,
      },
      rules: {
        field102: [{
          required: true,
          message: '请输入企业名称',
          trigger: 'blur'
        }],
        field105: [{
          required: true,
          message: '请选择数据来源',
          trigger: 'change'
        }],
        field104: [{
          required: true,
          message: '请选择数据类型',
          trigger: 'change'
        }],
        field107: [],
      },
      field106Action: 'https://jsonplaceholder.typicode.com/posts/',
      field106fileList: [],
      field105Options: [{
        "label": "主链",
        "value": "主链"
      }, {
        "label": "企业私链",
        "value": "企业私链"
      }],
      field104Options: [{
        "label": "电能",
        "value": "电能"
      }, {
        "label": "核能",
        "value": "核能"
      }, {
        "label": "氢气",
        "value": "氢气"
      }, {
        "label": "天然气",
        "value": "天然气"
      }, {
        "label": "其他",
        "value": "其他"
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    onOpen() {},
    onClose() {
      this.$refs['elForm'].resetFields()
    },
    close() {
      this.$emit('update:visible', false)
    },
    handleConfirm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        this.close()
      })
    },
    field106BeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 2
      if (!isRightSize) {
        this.$message.error('文件大小超过 2MB')
      }
      return isRightSize
    },
  }
}

</script>
<style>
.el-upload__tip {
  line-height: 1.2;
}

</style>
