import request from '@/utils/request'

export function getList(current, pageSize) {
  return request({
    url: `/score/list/${current}/${pageSize}`,
    method: 'get'
  })
}

export function edit(url, score) {
  return request({
    url: url,
    method: 'post',
    data: score,
    headers: {
      'Content-type': 'application/json'
    }
  })
}

export function del(id) {
  return request({
    url: `/score/del/${id}`,
    method: 'delete'
  })
}