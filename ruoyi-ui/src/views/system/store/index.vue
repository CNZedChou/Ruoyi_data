<template>
  <div>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
      <el-form-item label-width="200px" label="请输入新增加密数据信息" prop="field101">
        <el-button type="primary" icon="el-icon-button" size="medium">新增 </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        field101: undefined,
      },
      rules: {},
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {}
}

</script>
<style>
</style>
