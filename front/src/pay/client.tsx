import axios from "axios";

const client = axios.create({
  baseURL: process.env.NODE_ENV === "development" ? "/" : "https://example.com",
  withCredentials: true,
});

export interface Payment {
  buyer: string;
  orderId: string;
  method: PaymentMethod;
  name: string;
  amount: number;
  status: PaymentStatus;
  createAt: string;
  paidAt: string;
  failedAt: string;
  cancelledAmount: number;
  cancelledAt: string;
}

export type PaymentMethod = "card" | "trans" | "vbank" | "phone";
export type PaymentStatus = "ready" | "paid" | "failed" | "cancelled";

export interface PaymentRequest {
  name: string;
  amount: string;
}

export const requestPayment = (request: PaymentRequest) => client.post("/payments", request);

export const verifyPayment = (receiptId: string) => client.put(`/payment/${orderId}`, request);

export default client;
