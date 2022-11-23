"use strict";
// const requestPay = async () => {
//  try {
//      const response = await requestPayment({
//          name: 'my payment',
//             amount: '1000.0'
//         });
//         const payment = response.data as Payment;
//          /* 결제 요청 */
//  } catch (e) {
//             console.log(e);
//  }
// };
// const {IMP} = window;
// if (payment && IMP) {
//  const {orderId: merchant_uid, name} = payment;
//  IMP.init(userCode);
//  IMP.request_pay({
//      pg,
//         pay_method,
//         merchant_uid,
//         name,
//         amount,
//         buyer_email,
//         buyer_name,
//         buyer_tel,
//     }, rsp: RequestPayResponse => {
//      if (rsp.success) {
//          /* 결제 성공 시 */
//      } else {
//          /* 결제 실패 시 */
//      }
//  });
// }
// async (rsp: RequestPayResponse) => {
//  if (rsp.success) {
//      try {
//          const data = await verifyPayment({
//              receiptId: rsp.imp_uid!!,
//              orderId: rsp.merchant_uid
//             });
//              /* 결제 검증 성공 시 */
//              console.log(data);
//         } catch (e) {
//          /* 결제 검증 실패 시 */
//             alert(e);
//         }
//     } else {
//         alert(rsp.error_msg);
//     }
// }
