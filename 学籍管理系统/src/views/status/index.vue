<template>
    <div class="app-container">
  
      <el-button type="success" icon="el-icon-plus" @click="handleEdit">添加</el-button>
  
      <el-table
        :data="statues"
        :header-cell-style="{'text-align':'center'}"
        :cell-style="{'text-align':'center'}"
        style="width: 100%"
      >
      <!--<el-table-column
          label="ID"
          prop="id"
        />-->
        <el-table-column
          label="学号"
          prop="sno"
        />
        <el-table-column
          label="姓名"
          prop="name"
        />
        <el-table-column
          label="学籍状态"
          prop="status"
        />
        
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.row)"
            >编辑
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.row)"
            >删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        :page-size="pageSize"
        :current-page="page"
        :page-sizes="[5, 10, 15, 20]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
      <el-dialog :title="title" :visible.sync="dialogFormVisible">
        <el-form :model="statues">
          <el-form-item label="学号" :label-width="formLabelWidth">
            <el-input v-model="status.sno" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="status.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="学籍状态" :label-width="formLabelWidth">
            <el-input v-model="status.status" autocomplete="off"></el-input>
          </el-form-item>
          
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="save">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </template>
  
  <script>
  import { getList, edit, del } from '@/api/status'
  
  export default {
    data() {
      return {
        statues: [],
        status: {},
        page: 1,
        pageSize: 5,
        total: 20,
        dialogFormVisible: false,
        title: '添加学籍状态信息',
        formLabelWidth: '120'
      }
    },
    created() {
      this.findAll()
    },
    methods: {
      // 分页查询全部信息
      findAll() {
        getList(this.page, this.pageSize).then(res => {
          this.statues = res.data.records
          this.total = res.data.total
        })
      },
      // 编辑操作
      handleEdit(row) {
        // 判断是否是添加或修改
        if (row.id) {
          this.title = '修改状态信息'
          this.status = row
        } else {
          this.title = '添加状态信息'
          this.status = {}
        }
        // 打开对话框
        this.dialogFormVisible = true
      },
      // 保存数据
      async save() {
        // 设置添加url
        let url = '/status/add'
        // 判断是否是修改
        if (this.status.id) {
          url = '/status/update'
        }
        // 保存到数据库中
        const data = await edit(url, JSON.stringify(this.status))
        console.log('编辑状态：' + data.code)
        if (data.code === 20000) {
          // 关闭对话框
          this.dialogFormVisible = false
          // 刷新数据
          this.findAll()
        } else {
          this.$message.error({
            showClose: true,
            message: data.message
          })
        }
      },
      // 删除操作
      handleDelete(row) {
        console.log(row)
        this.$confirm(`您真的要删除该条信息吗？`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(async() => {
          const data = await del(row.id)
          if (data.code === 20000) {
            this.$message({
              type: 'success',
              message: '删除成功!',
              duration: 1000,
              onClose: () => {

                this.handleCurrentChange(1)

                this.total--
              }
            })
          } else {
            this.$message({
              type: 'info',
              message: '删除失败!'
            })
          }
        })
      },

      handleCurrentChange(page) {
        this.page = page
        getList(page, this.pageSize).then(res => {
          this.statues = res.data.records
        })
        console.log(`当前${page}页`)
      },

      handleSizeChange(pageSize) {
        this.pageSize = pageSize
        console.log(`当前${pageSize}页`)

        this.handleCurrentChange(this.page)
      }
    }
  }
  </script>
  <style>
  .el-pagination {
    margin-top: 20px;
    float: right;
  }
  </style>