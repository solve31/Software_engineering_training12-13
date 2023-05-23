import request from '@/utils/request'

export function getList(current, pageSize) {
  return request({
    url: `/award/list/${current}/${pageSize}`,
    method: 'get'
  })
}

export function edit(url, award) {
  return request({
    url: url,
    method: 'post',
    data: award,
    headers: {
      'Content-type': 'application/json'
    }
  })
}

export function del(id) {
  return request({
    url: `/award/del/${id}`,
    method: 'delete'
  })
}