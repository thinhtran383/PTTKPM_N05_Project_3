const axios = require('axios');

const apiUrl = 'https://online.mbbank.com.vn/api/retail_web/internetbanking/doLogin'

const axiosInstance = axios.create({
	baseURL: apiUrl,
	headers: {
    'Authorization': 'Basic RU1CUkVUQUlMV0VCOlNEMjM0ZGZnMzQlI0BGR0AzNHNmc2RmNDU4NDNm',
    'Content-Type': 'application/json; charset=UTF-8',
  },
});

const jsonData = {
	userId: 'VanAnhLu',
  password: '47c6b09ef7d658603d2ac5ba9383d730',
  captcha: '2yHtb2',
  sessionId: null,
  refNo: '1f5efa846b4e354fb8659b100325f81c-2023091600592659',
  deviceIdCommon: 'oankw8vh-mbib-0000-0000-2023090618002619',
}

axiosInstance.post('', jsonData)
  .then((response) => {
    console.log('Phản hồi từ máy chủ:', response.data);
  })
  .catch((error) => {
    console.error('Lỗi khi gửi yêu cầu:', error);
  });
