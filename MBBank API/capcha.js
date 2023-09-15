const axios = require('axios');

const apiUrl = 'https://online.mbbank.com.vn/api/retail-web-internetbankingms/getCaptchaImage';


// Tạo đối tượng Axios với xác thực HTTP Basic
const axiosInstance = axios.create({
  baseURL: apiUrl,
  headers: {
    'Authorization': 'Basic RU1CUkVUQUlMV0VCOlNEMjM0ZGZnMzQlI0BGR0AzNHNmc2RmNDU4NDNm',
    'Content-Type': 'application/json; charset=UTF-8',
  },
});

// Dữ liệu JSON bạn muốn gửi
const jsonData = {
  refNo: '2023091600484893',
  deviceIdCommon: 'oankw8vh-mbib-0000-0000-2023090618002619',
  sessionId: '',
};

// Gửi yêu cầu POST
axiosInstance.post('', jsonData)
  .then((response) => {
    console.log('Phản hồi từ máy chủ:', response.data);
  })
  .catch((error) => {
    console.error('Lỗi khi gửi yêu cầu:', error);
  });
