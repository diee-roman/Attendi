const baseUrl: string = "http://localhost/api"

export function addCustomerUrl(partnerId:number): string {
  return  `${baseUrl}/partners/${partnerId}/customers`;
}
