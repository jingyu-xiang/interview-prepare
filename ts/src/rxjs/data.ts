export type UserData = {
  data: { id: number; status: string; age: number }[];
};

export const data10users = new Promise<UserData>((resolve) =>
  resolve({
    data: [
      {
        id: 1,
        status: "active",
        age: 14,
      },
      {
        id: 1,
        status: "inactive",
        age: 12,
      },
      {
        id: 1,
        status: "active",
        age: 42,
      },
      {
        id: 1,
        status: "inactive",
        age: 42,
      },
      {
        id: 1,
        status: "active",
        age: 13,
      },
      {
        id: 1,
        status: "inactive",
        age: 75,
      },
      {
        id: 1,
        status: "inactive",
        age: 43,
      },
      {
        id: 1,
        status: "inactive",
        age: 54,
      },
      {
        id: 1,
        status: "active",
        age: 7,
      },
      {
        id: 1,
        status: "active",
        age: 17,
      },
    ],
  }),
);

export const data9users = new Promise<UserData>((resolve) =>
  resolve({
    data: [
      {
        id: 1,
        status: "active",
        age: 14,
      },
      {
        id: 1,
        status: "inactive",
        age: 12,
      },
      {
        id: 1,
        status: "active",
        age: 42,
      },
      {
        id: 1,
        status: "inactive",
        age: 42,
      },
      {
        id: 1,
        status: "active",
        age: 13,
      },
      {
        id: 1,
        status: "inactive",
        age: 75,
      },
      {
        id: 1,
        status: "inactive",
        age: 43,
      },
      {
        id: 1,
        status: "inactive",
        age: 54,
      },
      {
        id: 1,
        status: "active",
        age: 7,
      },
    ],
  }),
);