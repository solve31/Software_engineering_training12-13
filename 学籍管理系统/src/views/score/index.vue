<template>
    <div class="app-container">
  
      <el-button type="success" icon="el-icon-plus" @click="handleEdit">添加</el-button>
  
      <el-table
        :data="scores"
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
          label="分数"
          prop="grade"
        />
        <el-table-column
          label="课程名称"
          prop="cname"
        />
        <el-table-column
          label="课程性质"
          prop="type"
        />
        <el-table-column
          label="学分"
          prop="sc"
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
        <el-form :model="scores">
          <el-form-item label="学号" :label-width="formLabelWidth">
            <el-input v-model="score.sno" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="score.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="分数" :label-width="formLabelWidth">
            <el-input v-model="score.grade" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="课程号" :label-width="formLabelWidth">
            <el-input v-model="score.cno" autocomplete="off"></el-input>
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
  import { getList, edit, del } from '@/api/score'
  
  export default {
    data() {
      return {
        scores: [],
        score: {},
        page: 1,
        pageSize: 5,
        total: 20,
        dialogFormVisible: false,
        title: '添加成绩',
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
          this.scores = res.data.records
          this.total = res.data.total
        })
      },
      // 编辑操作
      handleEdit(row) {
        // 判断是否是添加或修改
        if (row.id) {
          this.title = '修改学生成绩'
          this.score = row
        } else {
          this.title = '添加学生成绩'
          this.score = {}
        }
        // 打开对话框
        this.dialogFormVisible = true
      },
      // 保存数据
      async save() {
        // 设置添加url
        let url = '/score/add'
        // 判断是否是修改
        if (this.score.id) {
          url = '/score/update'
        }
        // 保存到数据库中
        const data = await edit(url, JSON.stringify(this.score))
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
                // 页数跳转到第一页
                this.handleCurrentChange(1)
                // 总条数-1
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
      // 处理页数的改变
      handleCurrentChange(page) {
        this.page = page
        getList(page, this.pageSize).then(res => {
          this.scores = res.data.records
        })
        console.log(`当前${page}页`)
      },
      // 处理每页显示条数的改变
      handleSizeChange(pageSize) {
        this.pageSize = pageSize
        console.log(`当前${pageSize}页`)
        // 重新发请求查询数据
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