export const Message = {
  ENTRANCE_GREETING: 'Have a good time.',
  TICKET_PURCHASE_NOTICE: 'You should buy a ticket to enter theater.',
} as const;

export type MessageType = (typeof Message)[keyof typeof Message];
