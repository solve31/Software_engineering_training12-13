import request from '@/utils/request'

export function getList(current, pageSize) {
  return request({
    url: `/student/list/${current}/${pageSize}`,
    method: 'get'
  })
}

export function edit(url, student) {
  return request({
    url: url,
    method: 'post',
    data: student,
    headers: {
      'Content-type': 'application/json'
    }
  })
}

export function del(id) {
  return request({
    url: `/student/del/${id}`,
    method: 'get'
  })
}
